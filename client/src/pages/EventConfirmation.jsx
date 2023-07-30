import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import axios from 'axios'
import "./eventconfirmation.css"

const EventConfirmation = () => {
    const params = useParams()
    const cID = params.cID
    const eID = params.eID

    const [event, setEvent] = useState()
    //ex: {eventID: 2, location: "qweqweq", start_time: "2023-01-22 10:15:00", end_time: "2023-01-22 14:15:00", pID: 21, cID: 3}
    const [customer, setCustomer] = useState()
    //ex: {customerID: 3, phone: 9728459561, address: "4567 maple drive", Fname: "Jane", Lname: "Smith"}

    useEffect(() => {
        //get and store the event and customer info with axios
    }, [])

    return(
        <div className="eventConfirmation">
            Event successfully Created!
        </div>
    )
}

export default EventConfirmation