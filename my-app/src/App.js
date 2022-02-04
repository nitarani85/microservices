import logo from './logo.svg';
import './App.css';
import Login from './Component/Login'
import Register from './Component/Register';
import Chat from './Component/Chat';
import { Route,BrowserRouter as Router,Switch, } from 'react-router-dom';
function App() {
  return (
    <div>
    <Router>
      <Switch>
        <Route exact path="/">
        <Register/>
        </Route>
        <Route exact path="/login">
        <Login/>
        </Route>
        <Route exact path="/chat">
        <Chat/>
        </Route>
      </Switch>
    </Router>
    </div>
  );
}

export default App;
