/* eslint-disable react/jsx-key */
import {useState, useEffect} from "react"
import {Link, useParams} from "react-router-dom"
import "./createcustompackage.css"

const CreateCustomPackage = () => {
    const [availableItems, setAvailableItems] = useState()
    const [newCustomPackageItems, setNewCustomPackageItems] = useState()

    const [newItem, setNewItem] = useState() 
    const [newItemQuantity, setNewItemQuantity] = useState()

    const [validItemSelection, setValidItemSelection] = useState(false)

    const [totalPrice, setTotalPrice] = useState(0)

    useEffect(() => {
        //get all items from db and store in availableItems state
    }, [])

    const checkItemQuantity = (e) => {
        //selectedItem cannot be null
        const quantity = e.target.value

        if(quantity > newItem.stock) 
            alert("Please enter a quantity less than " + newItem.stock)
        else
        {
            setNewItemQuantity(quantity)
        }
    }

    const handleAddItemToPack = () => {
        if(newItemQuantity && newItem)
            setNewCustomPackageItems([[...newCustomPackageItems, {...newItem, quantity: newItemQuantity}]])
            setTotalPrice(totalPrice + (newItem.price * newItemQuantity))
    }

    const handleRemoveItemFromPack = () => {

    }

    return(
        <div className="createCustomPackage">
            <div className="createCustomPackge-itemSelection">
                <h1>Select Items</h1>
                <div className="itemSelection-content">
                    <div className="itemSelection-content-item">
                        <label>Item</label>
                        <select>

                        </select>
                    </div>
                    <div className="itemSelection-content-quanity">
                        <label>Quantity</label>
                        <input id="quantity-input" value={newItemQuantity} onChange={checkItemQuantity}/>
                    </div>
                    {(newItem && newItemQuantity) && <label>Price: {newItem.price * newItemQuantity}</label>}
                    <button onClick={handleAddItemToPack}>Add to Pack</button>
                </div>
            </div>
            <div className="createCustomPackage-packageView">
                <h1>Custom Pack</h1>
                {newCustomPackageItems && 
                newCustomPackageItems.map((item) => {
                    return(
                        <div>
                            {item.name}: x{item.quantity}
                            <button style={{color: "red"}} onClick={handleRemoveItemFromPack}>X</button>
                        </div>
                    )
                })}
                <p id="totalprice">Total: ${totalPrice}</p>
                <button>Confirm</button>
            </div>
        </div>
    )
}

export default CreateCustomPackage