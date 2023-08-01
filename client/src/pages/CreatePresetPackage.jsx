/* eslint-disable react/jsx-key */
import axios from "axios"
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom"
import "./createpresetpackage.css"

const CreatePresetPackage = () => {
    const navigate = useNavigate()
    const params = useParams()
    const cID = params.cID
    const eID = params.eID

    const [presetPackages, setPresetPackages] = useState()
    const [currentPackage, setCurrentPackage] = useState()
    const [packageAssigned, setPackageAssigned] = useState(false)
    const [price, setPrice] = useState()


    useEffect(() => {
        //default price is $100
        setPrice(100)

        const getListOfPresetPackages = async () => {
            //TODO
            //axios call to get all preset packages and store in presetPackages state
            const listOfPresetPackages = await axios.get(`http://127.0.0.1:8080/Package/getAllPresetPackages`)
            console.log(listOfPresetPackages)
            setPresetPackages(listOfPresetPackages.data)
        }

        getListOfPresetPackages()
    }, [])

    const confirmPackage = async () => {
        //set the event's pID to the currently selected preset package
        const newPID = currentPackage.packageID
        const updateEventPIDresult = await axios.put(`http://127.0.0.1:8080/event/updateEventPackage${newPID}/${eID}`)
        console.log(updateEventPIDresult)

        if(updateEventPIDresult.data == 1)
            setPackageAssigned(true)
    }

    const handlePackageSelect = (e) => {
        const packageName = e.target.value
        const packageObject = presetPackages.find((pack) => {return pack.name == ("p_"+packageName)})
        console.log(packageObject)
        setCurrentPackage(packageObject)
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
                        <select style={{border: "2px solid black", marginLeft: "10px"}} onChange={handlePackageSelect} id="createPresetPackage-select">
                            <option>--none--</option>
                            {presetPackages && presetPackages.map((pack) => {
                                return(
                                    <option>{pack.name.replace("p_", "")}</option>
                                )
                            })}
                        </select>
                    </label>
                </div>
                {(currentPackage && price) &&
                    <div className="createPresetPackage-content-priceInfo">
                        <label>Original Price: ${price}</label>
                        <label>Discount: {currentPackage.discount*100}%</label>
                        <label>Total: ${price - (price*currentPackage.discount)}</label>
                    </div>  
                }
                <button id="confirm-button" onClick={confirmPackage}>Confirm</button>
                <button id="nextpage-button" onClick={handleNextPage}
                    style={{backgroundColor: `${packageAssigned? "green":"grey"}`}}
                >Next</button>
            </div>
        </div>
    )
}

export default CreatePresetPackage