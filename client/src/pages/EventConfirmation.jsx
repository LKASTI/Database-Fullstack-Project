import axios from "axios"
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import "./eventconfirmation.css"

const EventConfirmation = () => {
    const params = useParams()
    const cID = params.cID
    const eID = params.eID

    const [event, setEvent] = useState()
    const [customer, setCustomer] = useState()

    useEffect(() => {
        //get and store the event and customer info with axios
        const getCustomer = async () => {
            const customers = await axios.get(`http://127.0.0.1:8080/Customer/getAllCustomers`)
            const person = customers.data.find((person) => person.customerID == cID)
            console.log(person)
            setCustomer(person)
        }

        const getEvent = async () => {
            const event = await axios.get(`http://127.0.0.1:8080/event/getEventForCustomer/${cID}`)
            console.log(event.data[0])
            setEvent(event.data[0])
        }

        getCustomer()
        getEvent()
    }, [])

    return(
        <div className="eventConfirmation" >
            Event successfully Created!<br/><br/>
            {(event && customer) && 
                <p>
                    <span>Customer: {customer.fname} {customer.lname}</span>
                    <span>Date: {event.start_Time.substring(0, 11)}</span>
                    <span>Time: {event.start_Time.substring(11, 16)} to {event.end_Time.substring(11, 16)}</span>
                </p>
            }
        </div>
    )
}

export default EventConfirmation