import { useState, useEffect } from "react"
import axios from 'axios'
import {Link, useParams} from "react-router-dom"
import "./createevent.css"

const CreateEvent = () => {
    const [startTime, setStartTime] = useState()
    const [endTime, setEndTime] = useState()
    const [packageType, setPackageType] = useState()
    const [eventAddress, setEventAddress] = useState()
    const [assignedEmployee, setAssignedEmployee] = useState()
    const [validEvent, setValidEvent] = useState(false)
    const [createdEvent, setCreatedEvent] = useState(false)

    //getting the cID from the URL
    const params = useParams()
    const cID = params.cID


    const checkTimes = async () => {
        //check if the given times conflict with a prexisting event and if an employee is able to attend
        //if the times are valid
            //store the employee id in assignedEmployee
            //if all event fields are filled 
                //set validEvent state to TRUE which allows submit button to become clickable and highlighted green
        
    }

    const createAnEvent = async () => {
        //create a default package
        /*
          create an event with
          assigned employee id, cID, 
          event address, start and end times,
          and any available vehicle ID
        */

        //set createdEvent state to TRUE
        //allows next button to be clickable and highlighted green
    }

    return(
        <div className="createEvent">
        </div>
    )
}

export default CreateEvent