import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig.js";
import Button from "../../components/button";
import Modal from "../../components/modal";
import {Badge, Fab} from "@material-ui/core";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            isSearch: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            qtyInCart: 0,
            cartItems: [],
            cartHidden: true,
        };
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleEditItem = this.handleEditItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleSearchItem = this.handleSearchItem.bind(this);
        this.handleSubmitSearchItem = this.handleSubmitSearchItem.bind(this);
    }

    componentDidMount() {
        console.log("componentDidMount()");
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

//    handleClickLoading() {
//        const currentLoading = this.state.isLoading;
//        this.setState({ isLoading: !currentLoading });
//        console.log(this.state.isLoading);
//    }

    handleAddItem() {
        this.setState({ isCreate:true });
        this.setState({
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0
        })
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate:false, isEdit: false, isSearch:false, cartHidden: true });
        this.loadData();
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
                })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            console.log("masuk try");
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            console.log("masuk try 2");
            await APIConfig.put(`/item/${this.state.id}`, data);
            console.log("masuk data");
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
              alert("Oops terjadi masalah pada server");
              console.log(error);
        }
        this.handleCancel(event);
    }

    handleSearchItem() {
        this.setState({ isSearch: true });
        this.setState({ items:[] });
    }

    async handleSubmitSearchItem(event) {
        event.preventDefault();
        try {
            const query = this.state.title;
            const { data } = await APIConfig.get("/item?title=" + query);
            this.setState({ items: data.result,
                            title:""});
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleAddToCart(item) {
        const currentItems = [...this.state.cartItems];
        const pickedItem = { ...item };
        const jumlah = this.state.qtyInCart;

//        event.preventDefault();
        try {
            if (pickedItem.quantity >= jumlah) { // quantity cukup
                currentItems.push(pickedItem);
                pickedItem.quantity = pickedItem.quantity - jumlah;
                const data = {
                    quantity: this.state.qtyInCart,
                    id_item: this.state.id,
                };
                await APIConfig.post("/cart", data);
            } else {
                alert("Stok tidak memenuhi!");
            }
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.setState({ cartItems: currentItems });
//        this.handleCancel(event);
    };

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    };

    render() {
        console.log("render()");
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>All Items</h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>

                    {this.state.cartHidden ?
                        <Fab variant="extended" onClick={this.handleToggle}>
                        <Badge color="secondary">
                            <ShoppingCartIcon/>
                        </Badge>
                        </Fab>
                    : <Button>
                          Checkout
                      </Button>}

                </div>
                <div>
                    {!this.state.cartHidden ? (
                    <div style={{ position: "fixed", top: 25, left: 25 }}>
                        <Button action={this.handleCancel}>
                            Back
                        </Button>
                        <p>Dalam Cart</p>
                    </div>
                    ) :
                    <div>
                        <Button action={this.handleAddItem}>
                            Add Item
                        </Button>
                        <Button action={this.handleSearchItem}>
                            Search Item
                        </Button>
                        {this.state.isSearch ? (
                        <div>
                            <form>
                                <input
                                className={classes.textField}
                                type="text"
                                placeholder="Nama Item"
                                name="title"
                                value={this.state.title}
                                onChange={this.handleChangeField}
                                />
                            </form>
                            <Button action={this.handleSubmitSearchItem}>
                                Search
                            </Button>
                            <Button action={this.handleCancel}>
                                Back
                            </Button>
                            <div>
                                {this.state.items.map((item) => (
                                    <Item
                                    key={item.id}
                                    id={item.id}
                                    title={item.title}
                                    price={item.price}
                                    description={item.description}
                                    category={item.category}
                                    quantity={item.quantity}
                                    />
                                ))}
                            </div>

                        </div>
                        ) :
                        <div>
                            {this.state.items.map((item) => (
                                <Item
                                key={item.id}
                                id={item.id}
                                title={item.title}
                                price={item.price}
                                description={item.description}
                                category={item.category}
                                quantity={item.quantity}
                                handleEdit={() => this.handleEditItem(item)}
                                handleAddCart={() => this.handleAddToCart(item)}
                                />
                            ))}
                        </div>}

                        <Modal
                        show={this.state.isCreate || this.state.isEdit}
                        handleCloseModal={this.handleCancel}
                        modalTitle={this.state.isCreate
                            ? "Add Item"
                            : `Edit Item ID ${this.state.id}`}
                        >
                            <form>
                                <input
                                className={classes.textField}
                                type="text"
                                placeholder="Nama Item"
                                name="title"
                                value={this.state.title}
                                onChange={this.handleChangeField}
                                />
                                <input
                                className={classes.textField}
                                type="number"
                                placeholder="Harga"
                                name="price"
                                value={this.state.price}
                                onChange={this.handleChangeField}
                                />
                                <textarea
                                className={classes.textField}
                                placeholder="Deskripsi"
                                name="description"
                                rows="4"
                                value={this.state.description}
                                onChange={this.handleChangeField}
                                />
                                <input
                                className={classes.textField}
                                type="text"
                                placeholder="Kategori"
                                name="category"
                                value={this.state.category}
                                onChange={this.handleChangeField}
                                />
                                <input
                                className={classes.textField}
                                type="number"
                                placeholder="Qty"
                                name="quantity"
                                value={this.state.quantity}
                                onChange={this.handleChangeField}
                                />
                                <Button action={this.state.isCreate
                                    ? this.handleSubmitItem
                                    : this.handleSubmitEditItem}
                                >
                                    Create
                                </Button>
                                <Button action={this.handleCancel}>
                                    Cancel
                                </Button>
                            </form>
                        </Modal>
                    </div>
                    }
                </div>

            </div>
        );
    }
}
export default ItemList;