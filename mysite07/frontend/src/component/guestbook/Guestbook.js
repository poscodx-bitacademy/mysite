import React from 'react';
import {MySiteLayout} from "../../layout";
import styles from '../../assets/scss/component/guestbook/Guestbook.scss';

function Guestbook(props) {
    return (
        <MySiteLayout>
            <div className={styles.Guestbook}>
                <h2>방명록</h2>
            </div>
        </MySiteLayout>
    );
}

export default Guestbook;