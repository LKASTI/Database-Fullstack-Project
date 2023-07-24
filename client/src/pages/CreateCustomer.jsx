import "./createcustomer.css"
import { useState } from "react"

const CreateCustomer = () => {
    // use axios to post the customer form data on submit
    // need to check if there isn't a prexisting customer with that info
    // once checked the customer doesn't already exist and the data is posted then hit next button to go to event creation page tied to customer ID in URL

    return(
        <div className="createCustomer">
            <h1 className="customer-info-label">Enter Customer Info</h1>
            <form className="customer-form">
                <div>
                    <label>Phone # xxxxxxxxx</label><br/>
                    <input className="customerform-input"></input>
                </div>

                <div>
                    <label>Address</label><br/>
                    <input className="customerform-input"></input>
                </div>

                <div>
                    <label>Date of Birth</label><br/>
                    <input type="date" className="customerform-input"></input>
                </div>

                <div>
                    <label>First Name</label><br/>
                    <input className="customerform-input"></input>
                </div>

                <div>
                    <label>Last Name</label><br/>
                    <input className="customerform-input"></input>
                </div>

                <input id="submit-customer" type="submit" value="Submit" />
            </form>
            
            <button>Next</button>
        </div>
    )
}

export default CreateCustomer