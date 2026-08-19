import { useParams } from "react-router-dom";
import { useEffect,useState } from "react";
function Content(){
   const {id} = useParams();
     const [FilterList, setListingfil] = useState([]);
     useEffect(() => {
       fetch("http://localhost:3000/schoolData")
         .then((data) => {
           if(!data.ok){
             throw new Error("Sorry Unable to load");
           }
         return data.json()})
         .then((data) => {
           setListingfil(data.students);
         });
     }, []);
     const ListFil = FilterList.find((item)=>item.id==id);
    return(
        <>
        {ListFil &&
        <div className="idHolder">
        <div className="idCard">
        <img src={ListFil.image} alt="sstudent image" />
<table className="TableC">
  <tbody>
    <tr>
      <td><strong>ID:</strong></td>
      <td className="last">{ListFil.id}</td>
    </tr>
    <tr>
      <td><strong>Name:</strong></td>
      <td className="last">{ListFil.Name}</td>
    </tr>
    <tr>
      <td><strong>Age:</strong></td>
      <td className="last">{ListFil.age} YEARS</td>
    </tr>
    <tr>
      <td><strong>Height:</strong></td>
      <td className="last">{ListFil.height} CM</td>
    </tr>
    <tr>
      <td><strong>Fee:</strong></td>
      <td className="last">₹{ListFil.priceFee}</td>
    </tr>
    <tr>
      <td><strong>Weight:</strong></td>
      <td className="last">{ListFil.weight} KG</td>
    </tr>
    <tr>
      <td><strong>Details:</strong></td>
      <td className="last">{ListFil.details}</td>
    </tr>
  </tbody>
  <video autoPlay muted loop className="Vidbg" >
<source src="http://localhost:3000/SchBg.mp4" type="video/mp4" />
</video>

</table>

        </div></div>
        
}
        </>
    );
}
export default Content;
