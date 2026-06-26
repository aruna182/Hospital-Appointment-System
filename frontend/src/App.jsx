import { Routes, Route } from "react-router-dom";

import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";

import DoctorList from "./pages/doctor/DoctorList";
import AddDoctor from "./pages/doctor/AddDoctor";
import EditDoctor from "./pages/doctor/EditDoctor";

import PatientList from "./pages/patient/PatientList";
import AddPatient from "./pages/patient/AddPatient";
import EditPatient from "./pages/patient/EditPatient";
import EditAppointment from "./pages/appointment/EditAppointment";


import AppointmentList from "./pages/appointment/AppointmentList";
import BookAppointment from "./pages/appointment/BookAppointment";
import AppointmentHistory from "./pages/appointment/AppointmentHistory";

import PrivateRoute from "./components/PrivateRoute";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />

      <Route
        path="/dashboard"
        element={
          <PrivateRoute>
            <Dashboard />
          </PrivateRoute>
        }
      />

      <Route path="/doctors" element={<DoctorList />} />
      <Route path="/addDoctor" element={<AddDoctor />} />
      <Route path="/editDoctor/:id" element={<EditDoctor />} />

      <Route path="/patients" element={<PatientList />} />
      <Route path="/addPatient" element={<AddPatient />} />
      <Route path="/editPatient/:id" element={<EditPatient />} />

      <Route path="/appointments" element={<AppointmentList />} />
      <Route path="/bookAppointment" element={<BookAppointment />} />
      <Route path="/history" element={<AppointmentHistory />} />

      <Route
path="/editAppointment/:id"
element={<EditAppointment/>}
/>

    </Routes>
  );
}

export default App;