import "./choosepackagetype.css";

const ChoosePackageType = ({isPresetPack, isCustomPack, setIsPresetPackage, setIsCustomPackage}) =>{

    return(
        <div className="choosePackage">
            <div className="choosePackage-presetPackage">
                <button 
                    onClick={() =>{
                        setIsPresetPackage(true)
                        setIsCustomPackage(false)
                    }} 
                    style={{backgroundColor: `${isPresetPack?"green": isCustomPack?"red":"rgb(187, 187, 187)"}`}}

                >
                    Preset
                </button>
                <p>
                    A preset package contains holiday/seasonsal themed items that are already provided. The price is already determined, and a discount is provided.
                </p>
            </div>
            <div className="choosePackage-customPackage">
                <button 
                    onClick={() =>{
                        setIsPresetPackage(false)
                        setIsCustomPackage(true)
                    }} 
                    style={{backgroundColor: `${isPresetPack?"red": isCustomPack?"green":"rgb(187, 187, 187)"}`}}
                    value={"Custom"}
                >
                    Custom
                </button>
                <p>
                    A custom package is includes items/services chosen by you without an included discount.
                </p>
            </div>
        </div>
    )
}

export default ChoosePackageType