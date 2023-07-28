import { useState } from "react";
import "./choosepackagetype.css"

const ChoosePackageType = ({isPresetPack, isCustomPack, setIsPresetPackage, setIsCustomPackage}) =>{

    return(
        <div className="choosePackage">
            <div className="choosePackage-presetPackage">
                <button 
                    onClick={() =>{
                        setIsPresetPackage(true)
                        setIsCustomPackage(false)
                    }} 
                    style={{backgroundColor: `${isPresetPack?"green": isCustomPack?"red":"grey"}`}}
                >
                    Preset
                </button>
                <p>
                    preset package description
                </p>
            </div>
            <div className="choosePackage-customPackage">
                <button 
                    onClick={() =>{
                        setIsPresetPackage(false)
                        setIsCustomPackage(true)
                    }} 
                    style={{backgroundColor: `${isPresetPack?"red": isCustomPack?"green":"grey"}`}}
                    value={"Custom"}
                >
                    Custom
                </button>
                <p>
                    custom package description
                </p>
            </div>
        </div>
    )
}

export default ChoosePackageType