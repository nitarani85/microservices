import React, { Component } from "react";
import axios from 'axios';
import {withRouter} from "react-router-dom";
 class Register extends Component {
  constructor(props)
{
    super(props);
    this.state={
        userName:"",
        name:"",
        email:""
    };
    
this.handleRegister=this.handleRegister.bind(this);
this.handleName=this.handleName.bind(this);
this.handleUserName=this.handleUserName.bind(this);
this.handleEmail=this.handleEmail.bind(this);

}
handleUserName(event)
{
  this.setState({userName:event.target.value})
}
handleEmail(event)
{
  this.setState({email:event.target.value})
}
handleName(event)
{
  this.setState({name:event.target.value})
}
handleRegister(event)
{
    const user={
        userName:this.state.userName,
        name:this.state.name,
        email:this.state.email
    }

    event.preventDefault();
    axios.post('http://localhost:8040/user/register',user)
    .then((res)=>{
        if(res.status==200)
        {
            alert("Registration done Successfully")
            this.props.history.push("/login");
        }
    
    })
    .catch((error)=>{
        alert(error);
    });
}

  render() {
    return (
      <div>
        <div className="container mt-5">
          <div className="card" style={{width: "55rem"}}>
            <div className="card-header text-center bg-info ">
              <h3>Register</h3>
            </div>
            <div className="card-body">
              <form className="mx-1 mx-md-4" onSubmit={this.handleRegister}>
                <div className="mb-3">
                  <label className="form-label" for="name">
                    Name{" "}
                  </label>
                  <input
                    className="form-control"
                    id="name"
                    placeholder="Your Name"
                    name="name"
                    onChange={this.handleName}
                  />
                </div>
                <div className="mb-3">
                  <label className="form-label" for="userName">
                    Username
                  </label>
                  <input
                    className="form-control"
                    id="userName"
                    placeholder="Username"
                    name="userName"
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
                    onChange={this.handleEmail}

                  />
                </div>
                <br/>
                <div
                  className="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                  style={{ textAlign: "center" }}
                >
                  <button className="btn btn-primary btn-lg" type="submit">
                    Register
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default withRouter(Register);