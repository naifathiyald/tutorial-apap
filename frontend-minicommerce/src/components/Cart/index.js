import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
import Item from "../Item/index.js";

const Cart = (props) => {
    const { id, quantity, item } = props;
    return (
        <div className={classes.item}>
            <h3>{`ID Cart: ${id}`}</h3>
            <p>{`Nama Barang: ${item.title}`}</p>
            <p>{`Harga: ${item.price}`}</p>
            <p>{`Jumlah: ${quantity}`}</p>
            <p>{`Deskripsi: ${item.description}`}</p>
            <p>{`Kategori: ${item.category}`}</p>
            <h4>{`Total Harga: ${quantity}`}</h4>
        </div>

    );
};

export default Item;