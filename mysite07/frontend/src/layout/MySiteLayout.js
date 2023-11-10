import React, {Fragment} from 'react';
import Header from "./Header";
import Navigation from "./Navigation";
import Footer from "./Footer";
import styles from '../assets/scss/layout/Content.scss';

export default function MySiteLayout({children}) {
    return (
        <Fragment>
            <Header/>
            <div className={styles.Content}>
                {children}
            </div>
            <Navigation/>
            <Footer/>
        </Fragment>
    );
}