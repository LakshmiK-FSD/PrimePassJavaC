import { useNavigate } from "react-router-dom";
function CardMaker(props){
   const navigating = useNavigate();
    return(
     <div key={props.Id} className="card"  onClick={()=>navigating("/content/"+props.Id)}>
        <img src={props.Image} alt="Student" />
        <h1>{props.Name}</h1>
        
    </div>
    );
}
export default CardMaker;