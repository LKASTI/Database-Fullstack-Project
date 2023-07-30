/* eslint-disable react/jsx-key */
import { useState, useEffect } from "react"
import { Link, useParams, useNavigate } from "react-router-dom"
import "./createpresetpackage.css"

const CreatePresetPackage = () => {
    const navigate = useNavigate()
    const params = useParams()
    const cID = params.cID
    const eID = params.eID

    const [presetPackages, setPresetPackages] = useState()
    const [currentPackage, setCurrentPackage] = useState()
    const [price, setPrice] = useState()


    useEffect(() => {
        //axios call to get all preset packages and store in presetPackages state
    }, [])

    const confirmPackage = async () => {
        //set the event's pID to the currently selected preset package
    }

    const handleNextPage = () => {
        navigate(`/event-confirmation/${cID}/${eID}`)
    }

    return(
        <div className="createPresetPackage">
            <div className="createPresetPackage-content">
                <label>Select a Package</label>
                <select>
                    {presetPackages && presetPackages.map((pack) => {
                        return(
                            <option onClick={setCurrentPackage(pack)}>{pack.name}</option>
                        )
                    })}
                </select>
                {(currentPackage && price) &&
                    <div className="createPresetPackage-content-priceInfo">
                        <label>Original Price: ${price}</label>
                        <label>Discount: {currentPackage.discount}%</label>
                        <label>Total: ${price * (1+currentPackage.discount/100)}</label>
                    </div>  
                }
                <button onClick={confirmPackage}>Confirm</button>
                <button onClick={handleNextPage}>Next</button>
            </div>
        </div>
    )
}

export default CreatePresetPackage