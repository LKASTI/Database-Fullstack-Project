import {useState, useEffect} from "react"
import {Link, useParams} from "react-router-dom"
import "./createcustompackage.css"

const CreateCustomPackage = () => {
    const [availableItems, setAvailableItems] = useState()
    const [newCustomPackage, setNewCustomPackage] = useState()
    const [selectedItem, setSelectedItem] = useState()

    const [newItemName, setNewItemName] = useState() 
    const [newItemQuantity, setNewItemQuantity] = useState()

    const [validItemSelection, setValidItemSelection] = useState(false)

    useEffect(() => {
        //get all items from db and store in availableItems state
    }, [])

    const checkItemQuantity = (e) => {
        //selectedItem cannot be null
        const quantity = e.target.value

        if(quantity > selectedItem.stock) 
            alert("Please enter a quantity less than " + selectedItem.stock)
        else
        {
            setNewItemQuantity(quantity)
        }
    }

    return(
        <div className="createCustomPackage">
            
        </div>
    )
}

export default CreateCustomPackage