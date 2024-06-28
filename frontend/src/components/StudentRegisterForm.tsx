import { ErrorOutline } from '@mui/icons-material';

import { Autocomplete, FormControl, FormHelperText, FormLabel, Input, Snackbar, Tooltip, styled } from '@mui/joy';
import { useMutation } from '@tanstack/react-query';
import { useAtom } from 'jotai/index';
import { useState } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { AdminStudentResourceService, CreateStudentDto } from '../state/api/generated';
import { useGetGradesForSchoolQuery } from '../state/api/grades.ts';
import { whoamiAtom } from '../state/api/whoami.ts';
import { AlternateButton } from './AlternateButton.tsx';

type Inputs = {
  firstname: string;
  middlename?: string;
  lastname: string;
  email: string;
  birthDate: string;
  password: string;
  grade: string;
};

const EMAIL_REGEX = /^[\w-.]+@([\w-]+\.)+[\w-]{2,}$/;
const PASSWORD_REGEX = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\w\d\s:])([^\s]){8,}$/;

export function StudentRegisterForm() {
  const [{ data: whoami }] = useAtom(whoamiAtom);
  const grades = useGetGradesForSchoolQuery(whoami.schools[0].id);
  const {
    register,
    handleSubmit,
    setError,
    formState: { errors },
  } = useForm<Inputs>();
  const [showSnackbarError, setShowSnackbarError] = useState(false);
  const registerMutation = useStudentRegisterMutation(whoami.schools[0].id, () => setShowSnackbarError(true));
  const onSubmit = (data: Inputs) => {
    const { firstname, middlename, lastname, email, birthDate, password } = data;
    if (!EMAIL_REGEX.test(email)) {
      setError('email', { type: 'invalid' });
      return;
    }
    if (!PASSWORD_REGEX.test(password)) {
      setError('password', { type: 'weak' });
      return;
    }

    registerMutation.mutate({
      firstname: firstname,
      middlename: middlename,
      lastname: lastname,
      email: email,
      birthDate: birthDate,
      password: password,
      schoolId: whoami.schools[0].id,
      gradeId: whoami.grades[0].id,
    });
  };
  console.log(grades);

  return (
    <>
      <StudentRegisterFormWrapper onSubmit={handleSubmit(onSubmit)}>
        <ThreeColGrid>
          <FixedHeightFormControl error={!!errors.firstname}>
            <StyledFormLabel>Vorname: *</StyledFormLabel>
            <Input {...register('firstname', { required: true })} placeholder={'Max'} />
            {errors.firstname && <FormHelperText>Vorname muss gesetzt sein</FormHelperText>}
          </FixedHeightFormControl>
          <FixedHeightFormControl>
            <StyledFormLabel>2. Vorname: </StyledFormLabel>
            <Input {...register('middlename')} placeholder={'Alexander'} />
          </FixedHeightFormControl>
          <FixedHeightFormControl error={!!errors.lastname}>
            <StyledFormLabel>Nachname: *</StyledFormLabel>
            <Input {...register('lastname', { required: true })} placeholder={'Mustermann'} />
            {errors.lastname && <FormHelperText>Nachname muss gesetzt sein</FormHelperText>}
          </FixedHeightFormControl>
        </ThreeColGrid>
        <TwoColGrid>
          <FixedHeightFormControl error={!!errors.email}>
            <StyledFormLabel>E-Mail: *</StyledFormLabel>
            <Input {...register('email', { required: true })} placeholder={'max.mustermann@email.com'} />
            <FormHelperText>
              {errors.email?.type == 'required' && 'E-Mail muss gesetzt sein'}
              {errors.email?.type == 'invalid' && 'E-Mail Adresse nicht gültig'}
            </FormHelperText>
          </FixedHeightFormControl>
          <FixedHeightFormControl error={!!errors.email}>
            <StyledFormLabel>Geburtsdatum: *</StyledFormLabel>
            <Input type="date" />
            <FormHelperText>
              {errors.email?.type == 'required' && 'Geburtsdatum muss gesetzt sein'}
              {errors.email?.type == 'invalid' && 'Geburtsdatum nicht gültig'}
            </FormHelperText>
          </FixedHeightFormControl>
        </TwoColGrid>

        <FixedHeightFormControl error={!!errors.password}>
          <StyledFormLabel>Passwort: *</StyledFormLabel>
          <Input {...register('password', { required: true })} type={'password'} placeholder={'********'} />
          {errors.password?.type == 'required' && <FormHelperText>Passwort muss gesetzt sein</FormHelperText>}
          {errors.password?.type == 'weak' && (
            <Tooltip
              placement={'bottom-start'}
              color="danger"
              title="Ihres Passwort muss mindesten 8 charaktere lang sein und muss Gross-/Kleinbuchstaben, Zahlen sowie
                            Sonderzeichen beinhalten">
              <FormHelperText>Passwort zu schwach</FormHelperText>
            </Tooltip>
          )}
        </FixedHeightFormControl>
        <FixedHeightFormControl error={!!errors.password}>
          <StyledFormLabel>Passwort: *</StyledFormLabel>
          {grades && <Autocomplete options={grades.grades.name} />}
          {errors.password?.type == 'required' && <FormHelperText>Passwort muss gesetzt sein</FormHelperText>}
          {errors.password?.type == 'weak' && (
            <Tooltip
              placement={'bottom-start'}
              color="danger"
              title="Ihres Passwort muss mindesten 8 charaktere lang sein und muss Gross-/Kleinbuchstaben, Zahlen sowie
                            Sonderzeichen beinhalten">
              <FormHelperText>Passwort zu schwach</FormHelperText>
            </Tooltip>
          )}
        </FixedHeightFormControl>

        <AlternateButton loading={registerMutation.isPending} type={'submit'} sx={{ width: '750px' }}>
          Schüler erstellen
        </AlternateButton>
      </StudentRegisterFormWrapper>
      <Snackbar
        open={showSnackbarError}
        color={'danger'}
        autoHideDuration={3000}
        onClose={() => {
          setShowSnackbarError(false);
        }}
        startDecorator={<ErrorOutline />}>
        Beim speichern Ihrer Registrierung, ist ein Fehler aufgetreten.
      </Snackbar>
    </>
  );
}

const useStudentRegisterMutation = (schoolId: string, onError: () => void) => {
  const navigate = useNavigate();

  return useMutation({
    mutationFn: (createStudentDto: CreateStudentDto) =>
      AdminStudentResourceService.createStudent(schoolId, createStudentDto),
    onSuccess: (response) => {
      console.log('happinesss');
    },
    onError,
  });
};

const StudentRegisterFormWrapper = styled('form')`
  min-height: 340px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;
const ThreeColGrid = styled('div')`
  display: grid;
  gap: 15px;
  grid-template-columns: repeat(3, minmax(0, 1fr));
  align-items: start;
  height: 90px;
`;
const TwoColGrid = styled('div')`
  display: grid;
  gap: 15px;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  align-items: start;
  height: 90px;
`;

const FixedHeightFormControl = styled(FormControl)`
  min-height: 100px;
`;

const StyledFormLabel = styled(FormLabel)`
  color: ${({ theme }) => theme.palette.primary[500]};
`;
