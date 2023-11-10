import React from 'react';
import {MySiteLayout} from "../../layout";
import styles from '../../assets/scss/component/user/User.scss';

export default function SignUp() {
    return (
        <MySiteLayout>
            <div className={styles.User}>
                <h2>Sign Up</h2>
            </div>
        </MySiteLayout>
    );
}