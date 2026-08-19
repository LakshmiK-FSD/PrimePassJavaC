import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Content from './Content.jsx';
import Card from './Card.jsx';
import './index.css';

const route = createBrowserRouter([
  {
    path: "/",
    element: <Card />
  },
  {
    path: "/content/:id",   
    element: <Content />
  }
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={route} />  
  </StrictMode>
);
