import { useEffect, useState } from 'react';
import CardMaker from './CardMaker';
function Card() {
  const [Listing, setListing] = useState([]);

  useEffect(() => {
    fetch("http://localhost:3000/schoolData")
      .then((data) => {
        if(!data.ok){
          throw new Error("Sorry Unable to load");
        }
      return data.json()})
      .then((data) => {
        setListing(data.students);
      });
  }, []);
  const List = Listing.map((item) => {
    const data = item;
    return (
      <CardMaker
        key={data.id}
        Name={data.Name}
        Id={data.id}
        Age={data.age}
        Height={data.height}
        Weight={data.weight}
        Detail={data.details}
        Image={data.image}
      />
    );
  });

  return (
    <>   <div className="holder">
      {List}
      </div>
    </>
  );
}

export default Card;
