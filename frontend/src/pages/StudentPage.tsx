import { Typography } from '@mui/joy';
import { useState } from 'react';
import { AlternateButton } from '../components/AlternateButton.tsx';
import { ContentSection } from '../components/ContentSection.tsx';
import { CreateStudent } from '../components/CreateStudent.tsx';
import { StudentTable } from '../components/StudentTable.tsx';

export function StudentPage() {
  const [open, setOpen] = useState(false);

  return (
    <ContentSection>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <Typography level="h3" margin={0} lineHeight={1}>
          Schülerübersicht
        </Typography>
        <AlternateButton onClick={() => setOpen(!open)}>Schüler hinzufügen</AlternateButton>
      </div>
      <StudentTable />
      <CreateStudent isOpen={open} setOpen={setOpen}></CreateStudent>
    </ContentSection>
  );
}
