import React from 'react';
import {NavLink} from "react-router-dom";
import styles from '../assets/scss/layout/Navigation.scss';

export default function Navigation() {
    return (
        <nav className={styles.Main}>
            <NavLink to={'/guestbook'}>방명록</NavLink>
            <NavLink to={'/gallery'}>갤러리</NavLink>
        </nav>
    );
}