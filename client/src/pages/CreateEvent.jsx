import { useState, useEffect } from "react"
import axios from 'axios'
import {Link, useParams, useNavigate} from "react-router-dom"
import ChoosePackageType from "../components/ChoosePackageType"
import "./createevent.css"

const CreateEvent = () => {
    const navigate = useNavigate()
    const [startTime, setStartTime] = useState()
    const [endTime, setEndTime] = useState()
    const [date, setDate] = useState()
    
    const [isPresetPack, setIsPresetPackage] = useState(false)
    const [isCustomPack, setIsCustomPackage] = useState(false)

    const [eventAddress, setEventAddress] = useState()
    const [assignedEmployee, setAssignedEmployee] = useState()
    const [validEvent, setValidEvent] = useState(false)
    const [eventCreated, setEventCreated] = useState(false)
    const [eID, setEID] = useState()

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

    const handleNextPage = (e) => {
        e.preventDefault()
        navigate(`/event-confirmation/${cID}/${eID}`)
        
        
    }

    return(
        <div className="createEvent">
            <ChoosePackageType 
                isPresetPack={isPresetPack} isCustomPack={isCustomPack}
                setIsPresetPackage={setIsPresetPackage} setIsCustomPackage={setIsCustomPackage}    
            />
            <form className="createEvent-form">
                <label id="event-info-title">Enter Event Info</label>

                <div className="createEvent-address-box">
                    <label>Address</label>
                    <input id="event-userinput"/>
                </div>

                <div className="createEvent-date-box">
                    <label>Date of Event</label>
                    <input id="event-userinput"/>
                </div>

                <div id="createEvent-eventTime-box">
                    <div className="eventTime-start_end">
                        <label>Start Time of Event</label>
                        <input id="event-userinput" type="time"/>

                        <label>End Time of Event</label>
                        <input id="event-userinput" type="time"/>
                    </div>
                    <button id="checkTimes-button" onClick={checkTimes}>Check<br/> Times</button>
                </div>

                <input id="submit-event" type="submit" value={"Submit"} 
                    style={{backgroundColor: `${validEvent? "green":"red"}`}}
                />

                <button id="next-button"
                    style={{backgroundColor: `${eventCreated? "green":"red"}`}}
                    onClick={handleNextPage}
                >
                    Next
                </button>
            </form>
        </div>
    )
}

export default CreateEvent