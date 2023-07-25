import {useState, useEffect} from "react"
import {Link, useParams} from "react-router-dom"
import "./createcustompackage.css"

const CreateCustomPackage = () => {
    const [availableItems, setAvailableItems] = useState()
    const [newCustomPackage, setNewCustomPackage] = useState()
    const [selectedItem, setSelectedItem] = useState()
    const [newItemName, setNewItemName] = useState() 
    const [newItemQuantity, setNewItemQuantity] = useState() 

    useEffect(() => {
        //get all items from db and store in availableItems state
    }, [])

    return(
        <div className="CreateCustomPackage">
        </div>
    )
}

export default CreateCustomPackage