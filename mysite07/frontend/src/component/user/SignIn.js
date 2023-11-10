import React from 'react';
import {MySiteLayout} from "../../layout";
import styles from '../../assets/scss/component/user/User.scss';

export default function SignIn() {
    return (
        <MySiteLayout>
            <div className={styles.User}>
                <h2>Sign In</h2>
            </div>
        </MySiteLayout>
    );
}