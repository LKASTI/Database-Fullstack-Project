import "./home.css"
import {Navigate, useNavigate} from "react-router-dom"


const Home = () => {
    const navigate = useNavigate()

    return(
        <div className="home">
            <div className="home-content">
                <p className="home-content-description">
                    Party Truck Service is a rental service that delivers event packages to you.
                </p>
                <div className="home-content-buttons">
                    <button onClick={() => {navigate("/customer-form")}} id="createReservation" className="home-createReservation-button">Create Reservation</button>
                    <button onClick={() => {navigate("/")}} className="home-viewReservation-button">View My Reservation</button>
                    <button onClick={() => {navigate("/")}} className="home-changeCustomer-button">Change Customer Info</button>
                </div>
            </div>
        </div>
    )
}

export default Home