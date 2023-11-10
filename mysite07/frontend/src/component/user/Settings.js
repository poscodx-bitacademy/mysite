import React from 'react';
import {MySiteLayout} from "../../layout";
import styles from '../../assets/scss/component/user/User.scss';

export default function Settings() {
    return (
        <MySiteLayout>
            <div className={styles.User}>
                <h2>Settings</h2>
            </div>
        </MySiteLayout>
    );
}