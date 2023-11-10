import React from 'react';
import {useRoutes} from 'react-router';
import './assets/scss/App.scss';

import {Main} from './component/main';
import {Guestbook} from './component/guestbook';
import {Gallery} from './component/gallery';
import SignIn from './component/user/SignIn';
import SignUp from './component/user/SignUp';
import Settings from './component/user/Settings';

export default function App() {
    return useRoutes([
        { path:'/gallery', element: <Gallery /> },
        { path:'/guestbook', element: <Guestbook /> },
        { path:'/user/login', element: <SignIn /> },
        { path:'/user/join', element: <SignUp /> },
        { path:'/user/settings', element: <Settings /> },
        { path:'*', element: <Main /> }
    ]);
}