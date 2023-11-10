import React from 'react';
import {MySiteLayout} from "../../layout";
import styles from '../../assets/scss/component/main/Main.scss';

export default function Main() {
    return (
        <MySiteLayout>
            <div className={styles.Main}>
                <h2>Main</h2>
            </div>
        </MySiteLayout>
    );
}