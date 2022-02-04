import React, { Component } from "react";
import axios from 'axios';
import {withRouter} from 'react-router-dom';
class Login extends Component {

  constructor(props)
  {
    super(props)
    this.state={
      userName:"",
    }
    this.handleUserName=this.handleUserName.bind(this);
    this.handleLogin=this.handleLogin.bind(this);

  }
  handleUserName(event)
  {
    this.setState({userName:event.target.value});
  }
  handleLogin(e)
  {
    e.preventDefault();
    console.log("first");
    axios.get(`http://localhost:8040/user/login/${this.state.userName}`)
    .then((res)=>{
      console.log(res);
      if(res.status==200)
        {
            alert("Login done Successfully")
            localStorage.setItem('userName',res.data.userName)
           alert(res.data.userName);
           console.log(res);
            this.props.history.push("/chat")
        }
    }
    )
    .catch((error)=>{
      alert(error);
  });  }
  render() {
    return (
      <div>
        <div className="container mt-5">
          <div className="card" style={{width: "55rem"}}>
            <div className="card-header text-center bg-info ">
              <h3>Login</h3>
            </div>
            <div className="card-body">
              <form className="mx-1 mx-md-4" onSubmit={this.handleLogin}>
                <div className="mb-3">
                  <label className="form-label" for="userName">
                    Username
                  </label>
                  <input
                    className="form-control"
                    id="userName"
                    placeholder="Username"
                    name="userName"
                    type="text"
                    onChange={this.handleUserName}
                  />
                </div>
                <div className="mb-3">
                  <label className="form-label" for="email">
                    Email address
                  </label>
                  <input
                    className="form-control"
                    id="email"
                    placeholder="Email"
                    name="email"
                    type="email"
                  />
                </div>
                <br/>
                <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4" style={{textAlign:"center"}}>
                  <button className="btn btn-primary btn-lg" type="submit">
                    Login
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}export default withRouter(Login);
