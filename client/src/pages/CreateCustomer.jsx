import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"
import "./createcustomer.css"

const CreateCustomer = () => {
    // use axios to post the customer form data on submit
    // need to check if there isn't a prexisting customer with that info
    // once checked the customer doesn't already exist and the data is posted then hit next button to go to event creation page tied to customer ID in URL
    const navigate = useNavigate()

    const [phoneNum, setPhoneNum] = useState()
    const [address, setAddress]  = useState()
    const [dob, setDob] = useState()
    const [fname, setFname] = useState()
    const [lname, setLname] = useState()
    const [cID, setCID] = useState()

    const [customerCreated, setCustomerCreated] = useState(false)

    const handleCustomerSubmission = async (e) => {
        e.preventDefault()
        const formattedDob = dob.replace("/", "-")
        const randID = Math.floor(Math.random() * (10000000))
        const newCustomer = {
            "customerID": randID,
            "phone": Number(phoneNum),
            "address": address,
            "Fname": fname,
            "Lname": lname,
            "DOB": formattedDob
        }

        console.log(newCustomer)
        const res = await axios.post("http://127.0.0.1:8080/Customer/create", newCustomer)
                    .then((res) => {console.log(res)})
                    .catch((err) => {console.log(err.response.data)})

        setCID(randID)
        setCustomerCreated(true)
    }

    const handleNextPage = () => {
        if(customerCreated)
            navigate(`/event-form/${cID}`)
        else
            alert("Please fill the entire form.")
        
    }

    return(
        <div className="createCustomer">
            <h1 className="customer-info-label">Enter Customer Info</h1>
            <form className="customer-form" onSubmit={handleCustomerSubmission}>
                <div>
                    <label>Phone # xxxxxxxxxx</label><br/>
                    <input className="customerform-input" required
                        value={phoneNum}
                        onChange={(e) => (setPhoneNum(e.target.value))}
                    />
                </div>

                <div>
                    <label>Address</label><br/>
                    <input className="customerform-input" required
                        value={address}
                        onChange={(e) => {setAddress(e.target.value)}}
                    />
                </div>

                <div>
                    <label>Date of Birth</label><br/>
                    <input type="date" className="customerform-input" required
                        value={dob}
                        onChange={(e) => {setDob(e.target.value)}}
                    />
                </div>

                <div>
                    <label>First Name</label><br/>
                    <input className="customerform-input" required
                        value={fname}
                        onChange={(e) => {setFname(e.target.value)}}
                    />
                </div>

                <div>
                    <label>Last Name</label><br/>
                    <input className="customerform-input" required
                        value={lname}
                        onChange={(e) => {setLname(e.target.value)}}
                    />
                </div>

                <input id="submit-customer" type="submit" value="Submit" />
            </form>
            
            <button id="nextpage-button" onClick={handleNextPage}
                style={{backgroundColor: `${customerCreated? "green":"grey"}`}}
            >Next</button>
        </div>
    )
}

export default CreateCustomer