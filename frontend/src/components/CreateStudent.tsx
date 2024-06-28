import { ErrorOutline } from '@mui/icons-material';
import { Modal, ModalDialog, Snackbar, Typography } from '@mui/joy';
import { useState } from 'react';
import { StudentRegisterForm } from './StudentRegisterForm.tsx';

export function CreateStudent({ isOpen, setOpen }: { isOpen: boolean; setOpen: (open: boolean) => void }) {
  const handleModalClose = () => setOpen(false);

  const [showSnackbar, setShowSnackbar] = useState(false);
  const [showSnackbarError, setShowSnackbarError] = useState(false);

  return (
    <>
      <Modal open={isOpen} onClose={handleModalClose}>
        <ModalDialog sx={{ padding: '30px' }}>
          <Typography level="h3" fontSize={35} marginBottom={2}>
            Neuer Schüler erstellen
          </Typography>
          <StudentRegisterForm />
        </ModalDialog>
      </Modal>
      <Snackbar
        open={showSnackbar}
        color={'success'}
        autoHideDuration={3000}
        onClose={() => {
          setShowSnackbar(false);
        }}>
        Klasse wurde erfolgreich erstellt
      </Snackbar>
      <Snackbar
        open={showSnackbarError}
        color={'danger'}
        autoHideDuration={3000}
        onClose={() => {
          setShowSnackbarError(false);
        }}
        startDecorator={<ErrorOutline />}>
        Ein Fehler ist wärend der Kreierung aufgetreten
      </Snackbar>
    </>
  );
}
