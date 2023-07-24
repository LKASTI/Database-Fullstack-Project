import react from 'react'
import {Navigate, useNavigate} from "react-router-dom"
import "./header.css"


const Header = () => {
    const navigate = useNavigate()

    return(
        <div className="header">
            <div className='header-title' onClick={() => {navigate("/home")}}>Party Truck Service</div>
        </div>
    )
}

export default Header