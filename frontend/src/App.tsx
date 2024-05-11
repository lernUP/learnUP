import { styled } from '@mui/joy';
import { Route, Routes, useLocation } from 'react-router-dom';
import { Header } from './components/Header.tsx';
import { GradePage } from './pages/GradePage.tsx';
import { LandingPage } from './pages/LandingPage.tsx';
import { LoginPage } from './pages/LoginPage.tsx';
import { RegisterPage } from './pages/RegisterPage.tsx';
import { StudentPage } from './pages/StudentPage.tsx';
import { TeacherPage } from './pages/TeacherPage.tsx';

export function App() {
  const Wrapper = styled('div')`
    min-height: 100vh;
    display: grid;
    grid-template-rows: auto 1fr;
  `;

  const location = useLocation();
  const showHeader: boolean = location.pathname !== '/login' && location.pathname !== '/register';

  return (
    <Wrapper>
      {showHeader && <Header />}
      <Routes>
        <Route path={'/'} element={<LandingPage />} />
        <Route path={'/login'} element={<LoginPage />} />
        <Route path={'/grades'} element={<GradePage />} />
        <Route path={'/register'} element={<RegisterPage />} />
        <Route path={'/students'} element={<StudentPage />} />
        <Route path={'/teachers'} element={<TeacherPage />} />
      </Routes>
    </Wrapper>
  );
}
