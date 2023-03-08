import React, { PropsWithChildren } from 'react';
import { ReactComponent as LogoDark } from './assets/svg/logo-dark.svg'
import { ReactComponent as Logo } from './assets/svg/logo.svg'
import { ReactComponent as Warning } from './assets/svg/error.svg'
import { ReactComponent as Account } from './assets/svg/account.svg'
import { ReactComponent as MagnifyingGlass } from './assets/svg/search.svg'
import { ReactComponent as Chevron } from './assets/svg/dropdown.svg'

const colors = {
  gray: '#bfbfbf',
  purple: '#4F2285',
  orange: 'orange'
}

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
    <form style={{ width: '100%', border: 'solid #bfbfbf 1px', borderRadius: 1, padding: '5px 8px' }}>
      <h2 style={{ marginLeft: 4 }}>{props.title}</h2>
      {props.children}
      <input type="submit" value="Continue" style={{ width: '100%', backgroundColor: 'orange', border: '1px solid gray', fontWeight: '600', padding: 6, margin: '7px 0px 10px' }} />
    </form>
  )
}

function Error(props: { message: string }) {
  return (
    <div style={{ display: 'flex', border: 'solid red 1px', flexDirection: 'row', padding: '8px 0px', marginBottom: 20 }}>
      <div style={{ display: 'flex', justifyContent: 'center', padding: '4px 4px 0px' }}>
        <Warning style={{ fill: 'red' }} />
      </div>
      <div>
        <p style={{ fontSize: 22, color: 'red', display: 'block' }}>There was a problem</p>
        <p>{props.message}</p>
      </div>
    </div>
  )
}

const Footer = <footer style={{ backgroundColor: '#4F2285', width: '100%' }}>
  <p style={{ textAlign: 'center', color: '#bfbfbf', padding: 20 }}>Copyright © 2023, ShopEZ.com, All rights reserved.</p>
</footer>

const SignInPage = <>
  <header style={{ display: 'flex', justifyContent: 'center', padding: 20 }}>
    <LogoDark />
  </header>
  <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'center', margin: '25px 50px' }}>
    <div style={{ width: 350, marginRight: 50 }}>
      <Error message='Error Message' />
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
</>

/**
 * Displays a screen width header which should be placed at the top of each page.
 * Contains an image which serves as a link back to the browse page, a search bar for the browse page, and a button which navigates to the account page.
 * @returns 
 */
function Header() {
  return (
    <div style={{ display: 'flex', flexDirection: 'row', backgroundColor: colors.purple, alignItems: 'center', padding: '10px 0' }}>
      <div style={{ flex: 1, margin: '0px 10px' }}>
        <Logo />
      </div>
      <div style={{ display: 'flex', flexDirection: 'row', height: 50, justifyContent: 'center', flex: 3, backgroundColor: 'blue' }}>
        <div style={{ backgroundColor: 'gray', display: 'flex', flexDirection: 'row', alignItems: 'center', justifyContent: 'center', width: 145, padding: 2, borderRadius: '5px 0px 0px 5px' }}>
          <p style={{ textAlign: 'center', fontSize: 14, borderRadius: '' }}>All Departments</p>
          <Chevron />
        </div>
        <input placeholder="Search ShopEZ" style={{ backgroundColor: 'white', flex: 1, width: 250, paddingLeft: 5, fontSize: 18 }}>
        </input>
        <div style={{ width: 50, backgroundColor: colors.orange, borderRadius: '0px 5px 5px 0px' }}>
          <MagnifyingGlass style={{ width: '100%', height: '100%' }} />
        </div>
      </div>
      <div style={{ margin: '0 10px', backgroundColor: 'red', width: 140, flex: 1 }}>
        <div style={{ border: '3px solid white', display: 'flex', alignItems: 'center', justifyContent: 'center', paddingRight: 9 }}>
          <Account style={{ width: 36, height: 36, fill: 'white' }} />
          <p style={{ color: 'white', fontSize: 20, fontWeight: 500 }}>Account</p>
        </div>
      </div>
    </div>
  )
}

/**
 * Displays a domain Product as it's image stacked on top of the product name and price
 * @param props 
 * @returns 
 */
function ProductListing(props: {name:string, price:string}) {
  return (
    <div style={{flexBasis:'21%', margin:'0 2% 20px'}}>
      <div style={{width:'100%', backgroundColor:'gray', aspectRatio:1}}>
        <img src=""/>
      </div>
      <div style={{paddingLeft:4}}>
        <p style={{margin:'5px 0'}}>{props.name}</p>
        <b>{props.price}</b>
      </div>
    </div>
  )

}

/**
 * Grid displaying {@link ProductListing}s.
 * Each row holds at most 4 elements.
 * @returns 
 */
function ProductListingGrid() {
  return (
    <div style={{margin:20, display:'flex', flexWrap:'wrap', backgroundColor:'lightblue'}}>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
      <ProductListing name='Product Name' price='$X.XX'/>
    </div>
  )
}


type PaginationItemText = '<' | '>' | '...' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'

/**
 * Displays a cell in the {@link Pagination} grid. Defaults to not being highlighted or disabled.
 * Cell should be highlighted if the text is a number representing the current page
 * Cell should be disabled if the text is an arrow and there are no more pages in the corresponding direction.
 * @param props 
 * @returns 
 */
function PaginationItem(props: {text: PaginationItemText, highlighted?: boolean, disabled?: boolean }) {
  const borderProps = props.highlighted ? '1px solid black' : `1px solid ${colors.gray}`
  const textColor = props.disabled ? colors.gray : 'black'

  return (
    <div style={{padding:'20px 30px', border:borderProps}}>
      <p style={{fontSize:24, backgroundColor:'white', color:textColor}}>{props.text}</p>
    </div>
  )
}

/**
 * Displays Pagination grid at bottom of browse page. 
 * At minimum, has 3 cells containing {@link PaginationItem}s for '<', '>', and '1'. 
 * Displays a '...' cell after the numerical cells when there are three page number cells being displayed but there are more pages to display.
 * @returns 
 */
function Pagination() {
  return (
    <div style={{display:'flex', flexDirection:'row', justifyContent:'center', margin:'0 10% 20px'}}>
        <PaginationItem text='<' disabled/>
        <PaginationItem text='1' highlighted/>
        <PaginationItem text='2'/>
        <PaginationItem text='3'/>
        <PaginationItem text='...' disabled/>
        <PaginationItem text='>' disabled/>
    </div>
  )
}

function App() {
  return (
    <div>
      <Header/>
      <ProductListingGrid/>
      <Pagination/>
      {Footer}
    </div>
  )
}

export default App;
