/* eslint-disable react/jsx-key */
import {useState, useEffect} from "react"
import {Link, useParams, useNavigate} from "react-router-dom"
import axios from "axios"
import "./createcustompackage.css"

const CreateCustomPackage = () => {
    const navigate = useNavigate()
    const params = useParams()
    const cID = params.cID
    const eID = params.cID
    const [availableItems, setAvailableItems] = useState()
    const [newCustomPackageItems, setNewCustomPackageItems] = useState([])

    const [newItem, setNewItem] = useState() 
    const [newItemQuantity, setNewItemQuantity] = useState()

    const [validItemSelection, setValidItemSelection] = useState(false)

    const [packageCreated, setPackageCreated] = useState(false)

    const [totalPrice, setTotalPrice] = useState(0)

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
            /**
             * TODO
             * create package 
             * 
             * for every item in newCustomPackageItems
             *      add the item to the package using axios method
             * 
             * get the event using cID
             * change the event package id to the new package id
             * store with axios
             * 
             * store true in packageCreated state when axios is successful
             */

            const newPID = Math.floor(Math.random() * (10000000))
            //create the package and add items
            let event = axios.get(`http://127.0.0.1:8080/event/getEventForCustomer/${cID}`)
            event = {...event, pID: newPID}

            //post new event
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
                            <button style={{color: "red", marginLeft: "5px"}} onClick={() => {
                                const newPack = newCustomPackageItems.filter((i) => i.name != item.name)
                                const newTotal = totalPrice - (item.price*item.quantity)
                                setNewCustomPackageItems(newPack)
                                setTotalPrice(newTotal)
                            }}>X</button>
                        </div>
                    )
                })}
                <p id="totalprice">Total: ${totalPrice}</p>
                <button id="confirm-button" onClick={handleConfirmPackage}>Confirm</button>
                <button id="nextpage-button"  onClick={handleNextPage}>Next</button>
            </div>
        </div>
    )
}

export default CreateCustomPackage