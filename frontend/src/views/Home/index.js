import React from "react";
import listItems from "../../items.json";
import List from "../../components/List/index";
import "./index.css";
import {Badge, Fab} from "@material-ui/core";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import ViewStreamIcon from '@mui/icons-material/ViewStream';

export default class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120,
        };
    }

    handleAddItemToCart = (item) => {
    	const currentItems = [...this.state.cartItems];
    	const newItem = { ...item };
    	const targetInd = currentItems.findIndex((it) => it.id === newItem.id);
    	if (targetInd < 0){ // newItem belum ada di dalam cartItems
    	    if (this.state.balance >= newItem.price) { // balance cukup
                newItem.inCart = true;
                currentItems.push(newItem);
                this.updateShopItem(newItem, true)
                this.setState({ balance: this.state.balance - newItem.price });
    	    } else {
    	        alert("Balance not sufficient!");
    	    }
    	}
    	this.setState({ cartItems: currentItems });
    };

    handleDeleteItemInCart = (item) => {
        const currentItems = [...this.state.cartItems];
        const deletedItem = { ...item };
        const targetInd = currentItems.findIndex((it) => it.id === deletedItem.id);

        if (targetInd >= 0) { // deletedItem ada di dalam cartItems
            currentItems.splice(targetInd, 1);
            deletedItem.inCart = false;
            this.updateShopItem(deletedItem, false)
            this.setState({ balance: this.state.balance + deletedItem.price });
        }
        this.setState({ cartItems: currentItems });
     };

    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems [targetInd].inCart = inCart;
        this.setState({ shopItems: tempShopItems });
    }

    handleToggle = () => {
    	const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    };

    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon/>
                            </Badge>
                            : <ViewStreamIcon/>}
                    </Fab>
                </div>
                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>
                <p className="text-center text-primary">Your Balance: <b> {this.state.balance}</b> </p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleDeleteItemInCart}
                                ></List>
                            </div>
                        ) : <div className="col-sm">
                                <List
                                    title="List Items"
                                    items={this.state.shopItems}
                                    onItemClick={this.handleAddItemToCart}
                                    isShopList={true}
                                ></List>
                            </div>}
                    </div>
                </div>
            </div>
        );
    }
}
