import { useState, useEffect } from "react"
import { Link, useParams } from "react-router-dom"
import "./createpresetpackage.css"

const CreatePresetPackage = () => {
    const params = useParams()
    const cID = params.cID
    const eID = params.eID

    const [presetPackages, setPresetPackages] = useState()
    const [currentPackage, setCurrentPackage] = useState()

    useEffect(() => {
        //axios call to get all preset packages and store in presetPackages state
    }, [])

    const confirmPackage = async () => {
        //set the event's pID to the currently selected preset package
    }

    return(
        <div className="">
        </div>
    )
}

export default CreatePresetPackage