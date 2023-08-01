/* eslint-disable react/jsx-key */
import { useState, useEffect } from "react"
import { Link, useParams, useNavigate } from "react-router-dom"
import axios from "axios"
import "./createpresetpackage.css"

const CreatePresetPackage = () => {
    const navigate = useNavigate()
    const params = useParams()
    const cID = params.cID
    const eID = params.eID

    const [presetPackages, setPresetPackages] = useState()
    const [currentPackage, setCurrentPackage] = useState()
    const [packageAssigned, setPackageAssigned] = useState()
    const [price, setPrice] = useState()


    useEffect(() => {
        //axios call to get all preset packages and store in presetPackages state
    }, [])

    const confirmPackage = async () => {
        //set the event's pID to the currently selected preset package
        const newPID = currentPackage.pID
        let event = axios.get(`http://127.0.0.1:8080/event/getEventForCustomer/${cID}`)
        event = {...event, pID: newPID}
    }

    const handleNextPage = () => {
        if (packageAssigned)
            navigate(`/event-confirmation/${cID}/${eID}`)
    }

    return(
        <div className="createPresetPackage">
            <div className="createPresetPackage-content">
                <div>
                    <label>
                        Select a Package
                        <select id="createPresetPackage-select">
                            {presetPackages && presetPackages.map((pack) => {
                                return(
                                    <option onClick={setCurrentPackage(pack)}>{pack.name}</option>
                                )
                            })}
                        </select>
                    </label>
                </div>
                {(currentPackage && price) &&
                    <div className="createPresetPackage-content-priceInfo">
                        <label>Original Price: ${price}</label>
                        <label>Discount: {currentPackage.discount}%</label>
                        <label>Total: ${price * (1+currentPackage.discount/100)}</label>
                    </div>  
                }
                <button id="confirm-button" onClick={confirmPackage}>Confirm</button>
                <button id="nextpage-button" onClick={handleNextPage}>Next</button>
            </div>
        </div>
    )
}

export default CreatePresetPackage