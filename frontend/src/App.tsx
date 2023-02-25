import React, { PropsWithChildren } from 'react';
import { ReactComponent as Logo } from './assets/svg/logo-dark.svg'

// const colors = {
//   gray: '#bfbfbf',
//   purple: '#4F2285',
//   orange: 'orange'
// }

function LoginInput(props: { label: string, errorMsg?: string }) {
  return (
    <div style={{ margin: '14px 0' }}>
      <label style={{ display: 'block', marginLeft: 4 }}><b>{props.label}</b></label>
      <input style={{ display: 'block', margin: '4px 0', border: 'solid #bfbfbf 1px', padding: '4px 0px', width: '100%' }}></input>
      <p style={{ color: 'red', fontSize: '14px' }}>{props.errorMsg}</p>
    </div>
  )
}

function LoginForm(props: { title: string } & PropsWithChildren) {
  return (
    <form style={{ width: '100%', border: 'solid #bfbfbf 1px', borderRadius: 3, padding: '5px 8px' }}>
      <h2 style={{ marginLeft: 4 }}>{props.title}</h2>
      {props.children}
      <input type="submit" value="Continue" style={{ width: '100%', backgroundColor: 'orange', border: '1px solid gray', fontWeight: '600', padding: 4, margin: '7px 0px 10px' }} />
    </form>
  )
}

const Footer = <footer style={{backgroundColor: '#4F2285', bottom: 0, position: 'absolute', width: '100%'}}>
    <p style={{textAlign: 'center', color: '#DDDDDD', padding: 20}}>Copyright © 2023, ShopEZ.com, All rights reserved.</p>
  </footer>


function App() {
  return (
    <div>
      <header style={{ display: 'flex', justifyContent: 'center', padding: 20 }}>
        <Logo />
      </header>
      <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'center', margin: '25px 50px' }}>
        <div style={{ width: 350, marginRight: 50 }}>
          <LoginForm title='Sign In'>
            <LoginInput label='Email' errorMsg='* Invalid email address' />
            <LoginInput label='Password' />
          </LoginForm>
        </div>
        <div style={{ width: 350, marginLeft: 50 }}>
          <LoginForm title='Create Account'>
            <LoginInput label='Email' />
            <LoginInput label='Password' />
            <LoginInput label='Re-enter Password' />
          </LoginForm>
        </div>
      </div>
      {Footer}
    </div>
  )
}

export default App;
