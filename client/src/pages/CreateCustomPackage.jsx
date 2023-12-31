/* eslint-disable react/jsx-key */
import axios from "axios"
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom"
import "./createcustompackage.css"

const CreateCustomPackage = () => {
    const navigate = useNavigate()
    const params = useParams()
    const cID = params.cID
    const eID = params.eID
    const [availableItems, setAvailableItems] = useState()
    const [newCustomPackageItems, setNewCustomPackageItems] = useState([])

    const [newItem, setNewItem] = useState() 
    const [newItemQuantity, setNewItemQuantity] = useState()

    const [validItemSelection, setValidItemSelection] = useState(false)

    const [packageCreated, setPackageCreated] = useState(false)

    const [totalPrice, setTotalPrice] = useState(0)

    /**
     * TODO
     * - populate items table with a bunch of items
     * - populate preset packages table with holiday themed packages
     */

    useEffect(() =>  {
        //get all items from db and store in availableItems state
        axios.get("http://127.0.0.1:8080/item/getAllItems")
            .then((res) => {
                console.log(res)
                setAvailableItems(res.data)
                console.log(res.data)
            }).catch((err) => {
                console.log(err)
            })
    }, [])

    useEffect(() => {
        if(newCustomPackageItems.length > 0)
        {
            setValidItemSelection(true)
        }
    }, [newCustomPackageItems])

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
            setNewCustomPackageItems([...newCustomPackageItems, {...newItem, quantity: newItemQuantity}])
            console.log([...newCustomPackageItems, {...newItem, quantity: newItemQuantity}])
            setTotalPrice(totalPrice + (newItem.price * newItemQuantity))
    }

    const handleItemSelect = async (e) => {
        const itemName = e.target.value
        const itemObject = availableItems.find((item) => item.name == itemName)
        console.log(itemObject)

        await setNewItem(itemObject)
    }

    const handleConfirmPackage = async () => {
        if(validItemSelection)
        {
            //create pID and assign to new package
            const newPID = Math.floor(Math.random() * (10000000))
            const newPackage = {
                packageID: newPID,
                name: "custom package",
                discount: 0.00
            }   
            const createPackageResult = await axios.post(`http://127.0.0.1:8080/Package/create`, newPackage)
            console.log(createPackageResult)
            //add all items to package if successful
            if(createPackageResult.data == 1)
            {
                //add all items in newCustomPackageItems
                newCustomPackageItems.map(async (item) => {
                    const itemID = item.itemID
                    const quantity = item.quantity

                    const addItemResult = await axios.put(`http://127.0.0.1:8080/Package/addItemToPackage${itemID}/${newPID}/${quantity}`)
                    console.log(addItemResult)
                    //change stock of item in DB
                    if(addItemResult.data == 1)
                    {
                        const newStock = item.stock - item.quantity
                        const updateItemStock = await axios.put(`http://127.0.0.1:8080/item/updateItemStock${newStock}/${item.name}`)
                        console.log("updatingStockResult: ", updateItemStock)
                    }
                })
                //post new event
                const updateEventPIDresult = await axios.put(`http://127.0.0.1:8080/event/updateEventPackage${newPID}/${eID}`)
                console.log(updateEventPIDresult)
                if(updateEventPIDresult.data == 1)
                    setPackageCreated(true)
            }
        }
    }

    const handleNextPage = () => {
        if(packageCreated)
        {
            navigate(`/event-confirmation/${cID}/${eID}`)
        }
        else
        {
            alert("Please add items to your package")
        }
    }

    return(
        <div className="createCustomPackage">
            <div className="createCustomPackage-itemSelection">
                <h1>Select Items</h1>
                <div className="itemSelection-content">
                    <div className="itemSelection-content-item">
                        <label>Item</label>
                        <select onChange={handleItemSelect}>
                            <option>--none--</option>
                            {availableItems && availableItems.map((item) => {
                                return(
                                    <option>{item.name}</option>
                                )
                            })}
                        </select>
                    </div>
                    <div className="itemSelection-content-quanity">
                        <label>Quantity</label>
                        <input id="quantity-input" value={newItemQuantity} onChange={checkItemQuantity}/>
                    </div>
                    <br/>
                    {(newItem && newItemQuantity) && <label>Price: ${newItem.price * newItemQuantity}</label>}
                    <br/>
                    <br/>
                    <button id="additem-button" onClick={handleAddItemToPack}>Add to Pack</button>
                </div>
            </div>
            <div className="createCustomPackage-packageView">
                <h1>Custom Pack</h1>
                {newCustomPackageItems && 
                newCustomPackageItems.map((item) => {
                    return(
                        <div>
                            {item.name}: x{item.quantity}
                            <button style={{color: "red",fontSize: "20px", fontWeight: "bold", 
                                            marginLeft: "5px", backgroundColor: "#ffcccb", padding: "0px 8px", borderRadius: "20px"}} 
                                onClick={() => {
                                    const newPack = newCustomPackageItems.filter((i) => i.name != item.name)
                                    const newTotal = totalPrice - (item.price*item.quantity)
                                    setNewCustomPackageItems(newPack)
                                    setTotalPrice(newTotal)
                                }}
                            >
                                X
                            </button>
                        </div>
                    )
                })}
                <p id="totalprice">Total: ${totalPrice}</p>
                <button id="confirm-button" onClick={handleConfirmPackage}>Confirm</button>
                <button id="nextpage-button"  
                    style={{backgroundColor: `${packageCreated? "green":"grey"}`}}
                    onClick={handleNextPage}
                >Next</button>
            </div>
        </div>
    )
}

export default CreateCustomPackage