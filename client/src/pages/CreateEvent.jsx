import axios from 'axios'
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom"
import ChoosePackageType from "../components/ChoosePackageType"
import "./createevent.css"

const CreateEvent = () => {
    const navigate = useNavigate()
    const [startTime, setStartTime] = useState()
    const [endTime, setEndTime] = useState()
    const [validTimes, setValidTimes] = useState(false)
    const [date, setDate] = useState()
    
    const [isPresetPack, setIsPresetPackage] = useState(false)
    const [isCustomPack, setIsCustomPackage] = useState(false)

    const [eventAddress, setEventAddress] = useState()
    const [validEvent, setValidEvent] = useState(false)
    const [eventCreated, setEventCreated] = useState(false)
    const [eID, setEID] = useState()

    //getting the cID from the URL
    const params = useParams()
    const cID = params.cID

    useEffect(() => {
        if(eventAddress && (isPresetPack || isCustomPack) && validTimes)
            setValidEvent(true)
    }, [eventAddress, isPresetPack, isCustomPack, validTimes])

    const checkTimes = async (e) => {
        e.preventDefault()
        if(startTime == null || endTime == null || date == null)
        {
            alert("Please fill the date, and time fields")
            return
        }
        
        const formattedStartTime = date + " " + startTime + ":00"
        const formattedEndTime = date + " " + endTime + ":00"
        //check for time conflict
        const timeIsNotAvailable = await axios.get(`http://127.0.0.1:8080/event/eventTimeConflict/${formattedStartTime}/${formattedEndTime}`)

        if(timeIsNotAvailable.data == false)
        {
            setValidTimes(true)
            alert("Success! Times are available")
        }
        else
        {
            setValidTimes(false)
            alert("An event is already scheduled at this time. Please choose a different time.")
        }
    }

    const createAnEvent = async (e) => {
        e.preventDefault()
        if(validEvent)
        {
            if (isPresetPack || isCustomPack)
            {
                const newEID = Math.floor(Math.random() * (10000000))
                setEID(newEID)
                const formattedStartTime = date + " " + startTime + ":00"
                const formattedEndTime = date + " " + endTime + ":00"
                const event = {
                    eventID: newEID,
                    location: eventAddress,
                    start_time: formattedStartTime,
                    end_time: formattedEndTime,
                    pID: 1,
                    cID: cID
                }
    
                const res = await axios.post("http://127.0.0.1:8080/event/create", event)
                console.log("Event created status: ", res.data)

                if(res.data == 1)
                {
                    setEventCreated(true)
                    //assign employee
                    const employees = await axios.get("http://127.0.0.1:8080/fullTimeEmployee/getAllFullTimeEmployees")
                    const empID = employees.data[0].employeeID
                    console.log("Employee retrieved status: ", empID)
                    const empStatus = await axios.post(`http://127.0.0.1:8080/fullTimeEmployee/saveEmployeeWorksOn/${empID}/${newEID}`)
                    console.log("Employee assigned status: ", empStatus.data)
                    //assign vehicle
                    const vehicleStatus = await axios.post(`http://127.0.0.1:8080/Vehicle/assignVehicleToEvent${newEID}`)
                    console.log("Vehicle assigned status: ", vehicleStatus.data)
                }
                else
                {
                    alert("Error occurred. Please refresh page.")
                }
            }
            else
            {
                alert("Please choose either a preset or custom package")
            }
        }
        else
        {
            alert("Please fill all event form details.")
        }
    }

    const handleNextPage = (e) => {
        e.preventDefault()
        if(eventCreated)
        {
            if(isPresetPack)
                navigate(`/preset-package-form/${cID}/${eID}`)
            else if(isCustomPack)
                navigate(`/custom-package-form/${cID}/${eID}`)
        }
        else
            alert("Please fill out all details in the form.")
    }

    return(
        <div className="createEvent">
            <ChoosePackageType 
                isPresetPack={isPresetPack} isCustomPack={isCustomPack}
                setIsPresetPackage={setIsPresetPackage} setIsCustomPackage={setIsCustomPackage}    
            />
            <form className="createEvent-form" onSubmit={createAnEvent}>
                <label id="event-info-title">Enter Event Info</label>

                <div className="createEvent-address-box">
                    <label>Address</label>
                    <input id="event-userinput" 
                        required
                        value={eventAddress}
                        onChange={(e) => {setEventAddress(e.target.value)}}
                    />
                </div>

                <div className="createEvent-date-box">
                    <label>Date of Event</label>
                    <input id="event-userinput" type="date" 
                        required
                        value={date} 
                        onChange={(e) => {setDate(e.target.value)}}
                    />
                </div>

                <div id="createEvent-eventTime-box">
                    <div className="eventTime-start_end">
                        <label>Start Time of Event</label>
                        <input id="event-userinput" type="time"
                            required
                            onChange={(e) => {setStartTime(e.target.value)}}
                        />
                        <label>End Time of Event</label>
                        <input id="event-userinput" type="time"
                            required
                            onChange={(e) => {setEndTime(e.target.value)}}
                        />
                    </div>
                    <button id="checkTimes-button" onClick={checkTimes}>Check<br/> Times</button>
                </div>

                <input id="submit-event" type="submit" value={"Submit"} 
                    style={{backgroundColor: `${validEvent? "green":"red"}`}}
                />

                <button id="nextpage-button"
                    style={{backgroundColor: `${eventCreated? "green":"grey"}`}}
                    onClick={handleNextPage}
                >
                    Next
                </button>
            </form>
        </div>
    )
}

export default CreateEvent