import React, {useState, useEffect} from 'react';
import {MySiteLayout} from "../../layout";
import Header from "./Header";
import ImageList from "./ImageList";
import styles from '../../assets/scss/component/gallery/Gallery.scss';
import data from '../../assets/json/data';

export default function Index() {
    const [imageList, setImageList] = useState(data);

    const addImage = async (comment, file) => {
        try {
            // Create FormData
            const formData = new FormData();
            formData.append('comments', comment);
            formData.append('file', file);

            // Post
            const response = await fetch(`/api/gallery`, {
                method: 'post',
                headers: {'Accept': 'application/json'},
                body: formData
            });

            if (!response.ok) {
                throw `${response.status} ${response.statusText}`;
            }

            // API success?
            const json = await response.json();
            if (json.result !== 'success') {
                throw json.message;
            }

            // Rendering(Update)
            setImageList([json.data, ...imageList]);
        } catch (err) {
            console.error(err);
        }
    };


    return (
        <MySiteLayout>
            <div className={styles.Gallery}>
                <Header addImage={addImage}/>
                <ImageList imageList={imageList} />
            </div>
        </MySiteLayout>
    )
}