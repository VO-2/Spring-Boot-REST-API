import React, { PropsWithChildren } from 'react';
import { ReactComponent as LogoDark } from './assets/svg/logo-dark.svg'
import { ReactComponent as Logo } from './assets/svg/logo.svg'
import { ReactComponent as Warning } from './assets/svg/error.svg'
import { ReactComponent as Account } from './assets/svg/account.svg'
import { ReactComponent as MagnifyingGlass } from './assets/svg/search.svg'
import { ReactComponent as Chevron } from './assets/svg/dropdown.svg'
import { ReactComponent as Plus } from './assets/svg/plus.svg'
import productPlaceholder from './assets/image/placeholder.jpg'

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
 * Displays screen width footer. Should be the last component in the {@link App} container.
 * @returns 
 */
function Footer() {
  return (
    <footer>
      <p>Copyright © 2023, ShopEZ.com, All rights reserved.</p>
    </footer>
  )
}

/**
 * Displays a screen width header which should be placed at the top of each page.
 * Contains an image which serves as a link back to the browse page, a search bar for the browse page, and a button which navigates to the account page.
 * @Issue Doesn't scale properly when resizing page
 * @returns 
 */
function Header() {
  return (
    <header style={{ display: 'flex', flexDirection: 'row', backgroundColor: colors.purple, alignItems: 'center', padding: '10px 0' }}>
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
    </header>
  )
}

/**
 * Displays a domain Product as it's image stacked on top of the product name and price
 * @param props 
 * @returns 
 */
function ProductListing(props: {name:string, price:string}) {
  return (
    <div className='product-listing-container'>
      <img src={productPlaceholder} className='product-listing-image'/>
      <div className='product-listing-label'>
        <p>{props.name}</p>
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
function ProductListingGrid(props: PropsWithChildren) {
  return (
    <div className='product-listing-grid'>
      {props.children}
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
 * Should be placed after ProductListingGrid. 
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

/**
 * Displays the purchase page for a given product.
 * @param props 
 * @returns 
 */
function ProductPurchase(props: {productName: string, productDescription: string, productPrice: number}) {
  return (
    <div className='product-purchase-container'>
        <img src={productPlaceholder}/>
        <div className='product-purchase-label'>
          <div>
            <h2>Product Name</h2>
            <p id='product-purchase-description'><b> Product Description Product Description Product Description Product Description Product Description Product Description</b></p>
            <b id='product-purchase-price'>$X.XX</b>
          </div>
          <button className='orange-button'>
            Buy now
          </button>
        </div>
      </div>
  )
}

/**
 * Page where user can create or update a product.
 * @param props 
 * @returns 
 */
function ProductManager(props: {productName: string, productDescription: string, productPrice: number}) {
  return (
    <form className='product-purchase-container product-manager-container'>
      <div style={{display:'flex', alignItems:'center', flexDirection:'column'}}>
        <img src={productPlaceholder}/>
        <input type="file" accept='.png, .jpg, .jpeg' style={{visibility:'hidden'}}/>
        {/* Clicking this button should simulate a click on the hidden image input */}
        <button id='change-image'>Change Image</button>
      </div>
      <div className='product-purchase-label'>
        <div>
          <input type='text' id='product-name-input' className='header2 product-manager-input' placeholder='Edit Product Name'/>
          <textarea rows={14} cols={1} placeholder='Edit Description' className='product-manager-input' id='product-purchase-description'/>
          {/* Will be controlled with Currency.js */}
          <input className='product-purchase-price product-manager-input' type='text' placeholder='$9.99' size={15}/>
        </div>
        <button type='submit' className='orange-button'>Save Changes</button>
      </div>
    </form>
  )
}

/**
 * Displays an object belonging to a {@link Purchase}
 * @param props 
 * @returns 
 */
function PurchaseEntry(props: {productName: string, price: string}) {
  return (
    <div className='purchase-entry-container'>
      <img src="/assets/image/placeholder.jpg"/>
      <div className='purchase-entry-label'>
        <p>{props.productName}</p>
        <p><b>{props.price}</b></p>
      </div>
    </div>
  )
}

/**
 * Displays a domain purchase object. 
 * To be rendered in the Account page after the 'Your Purchases' header
 * Takes {@link PurchaseEntry} elements as children
 * @param props 
 * @returns 
 */
function Purchase(props: {purchaseDate: Date, total: number, orderNumber: number}) {
  return (
    <div className='purchase-container'>
      <div className='purchase-header'>
        <div>
          <p>PURCHASE DATE</p>
          <p>{props.purchaseDate.toLocaleDateString()}</p>
        </div>
        <div>
          <p>TOTAL</p>
          <p>{props.total}</p>
        </div>
        <div>
          <p>ORDER #</p>
          <p>{props.orderNumber}</p>
        </div>
      </div>
      <div className='purchase-body'>
        <PurchaseEntry productName='Product' price='$X.XX'/>
        <PurchaseEntry productName='Product' price='$X.XX'/>
      </div>
    </div>
  )
}

/**
 * Page displaying the logged in user's uploaded products and previous purchases.
 * Displays buttons to create a new product and to log out.
 * Page is only accessible to authenticated users. Unauthorized users should be redirected to the login page.
 * @returns 
 */
function AccountPage() {    
  return (
    <div>
      <h2 className='account-section-header'>
        Your Items
      </h2>
      <ProductListingGrid>
        <div className='product-listing-container' id='product-listing-new-product'>
          <div className='product-listing-image'><Plus/></div>
          <button className='orange-button'>New Product</button>
        </div>
        <ProductListing name='Product Name' price='$X.XX'/>
      </ProductListingGrid>
      <h2 className='account-section-header'>
        Your Purchases
      </h2>
      <div>
        <Purchase purchaseDate={new Date()} total={20.99} orderNumber={5041}/>
        <Purchase purchaseDate={new Date()} total={14.65} orderNumber={3450}/>
      </div>
      <div className='account-section-header'>
        <button className='orange-button logout-button'>
          Logout
        </button>
      </div>
    </div>
  )
}

/**
 * TODO: Update footer so that it switches between relative and absolute positioning based on page content
 * @returns 
 */
function App() {    

  return (
    <>
      <Header/>
      <ProductManager productName='Name' productDescription='Description' productPrice={9.99}/>
      <Footer/>
    </>
  )
}

export default App;
