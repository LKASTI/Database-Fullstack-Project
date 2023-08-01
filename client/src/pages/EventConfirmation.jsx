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
    }, [])

    return(
        <div className="eventConfirmation">
            Event successfully Created!
        </div>
    )
}

export default EventConfirmation