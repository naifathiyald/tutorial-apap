import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
import ItemList from "../../containers/itemlist";

const Item = (props) => {
    const { id, title, price, description, category, quantity, handleEdit, handleDelete, qtyInCart, onItemClick} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
            <Button action={handleDelete}>
                Delete
            </Button>
            <div>
                <input
                    className={classes.textField}
                    type="number"
                    placeholder="Qty"
//                    value={this.state.qtyInCart}
//                    onChange={this.handleChangeField}
                />

            <Button>
                Add to Cart
            </Button>
            </div>
        </div>

    );
};

export default Item;