import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import {useState, useContext, createContext} from 'react'
import './App.css'
import Home from "./pages/Home"
import CreateCustomer from "./pages/CreateCustomer"
import CreateEvent from "./pages/CreateEvent"
import CreatePresetPackage from "./pages/CreatePresetPackage"
import CreateCustomPackage from "./pages/CreateCustomPackage"
import EventConfirmation from "./pages/EventConfirmation"
import Header from "./components/Header"

export const AppContext = createContext()

function App() {


  return (
    <AppContext.Provider values = {{}}> 
      <Router>
        <div>
          <Header/>
          <Routes>
            <Route path = "/" element={<Home/>}/>
            <Route path = "/home" element={<Home/>}/>
            <Route path = "/customer-form" element={<CreateCustomer/>}/>
            <Route path = "/event-form/:cID" element={<CreateEvent/>}/>
            <Route path = "/preset-package-form/:cID/:eID" element={<CreatePresetPackage/>}/>
            <Route path = "/custom-package-form/:cID/:eID" element={<CreateCustomPackage/>}/>
            <Route path = "/event-confirmation/:cID/:eID" element={<EventConfirmation/>}/>
            <Route path="*" element={<h1>ERROR 404 PAGE NOT FOUND</h1>}/>
          </Routes>
        </div>
      </Router>
    </AppContext.Provider>
  )
}

export default App
