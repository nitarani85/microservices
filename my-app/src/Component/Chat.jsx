import React, { Component } from "react";
import './Chat.css';
import axios from 'axios';

export default class Chat extends Component {
  constructor(props)
  {
    super(props)
    this.state={
      users:[],
      userName:""
    }
  }

  componentDidMount()
  {
    const userName=localStorage.getItem('userName')
    axios.get(`http://localhost:8040/user/allUser/${userName}`)
    .then((res)=>{
      this.setState({users:res.data})
    })
  }
  render() {
    return (
      <div>
        <div id="container">
          <aside>
            <header>
              <input type="text" placeholder="search" />
            </header>
            <ul>
            {this.state.users.map((user)=>(

              <li key={user.userId}>
                <img
                  src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_02.jpg"
                  alt=""
                />
                <div>
                  <h2>{user.name}</h2>
                  <h3>
                    <span className="status green"></span>
                    online
                  </h3>
                </div>
              </li>
              ))}
            </ul>

          </aside>
          <main>
            <header>
              <img
                src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/chat_avatar_01.jpg"
                alt=""
              />
              <div>
                <h2>Chat with Vincent Porter</h2>
                <h3>already 1902 messages</h3>
              </div>
              <img
                src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_star.png"
                alt=""
              />
            </header>
            <ul id="chat">
              <li className="you">
                <div className="entete">
                  <span className="status green"></span>
                  <h2>Vincent</h2>
                  <h3>10:12AM, Today</h3>
                </div>
                <div className="triangle"></div>
                <div className="message">
                  Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                  Aenean commodo ligula eget dolor.
                </div>
              </li>
            </ul>
            <footer>
              <textarea placeholder="Type your message"></textarea>
              <img
                src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_picture.png"
                alt=""
              />
              <img
                src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1940306/ico_file.png"
                alt=""
              />
              <a href="#">Send</a>
            </footer>
          </main>
        </div>
      </div>
    );
  }
}
