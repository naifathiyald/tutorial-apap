import React from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import Item from './containers/itemlist';

export const AppRoutes = () => {
    return (
        <div>
            <Switch>
                <Route exact path="/" component={Item} />
                <Route exact path="/">
                    <Redirect to="/" />
                </Route>
            </Switch>
        </div>
    );
};