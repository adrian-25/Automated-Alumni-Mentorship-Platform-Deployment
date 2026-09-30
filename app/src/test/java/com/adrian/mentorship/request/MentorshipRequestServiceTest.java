package com.adrian.mentorship.request;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.adrian.mentorship.alumni.AlumniRepository;
import com.adrian.mentorship.student.StudentRepository;
import org.junit.jupiter.api.Test;

class MentorshipRequestServiceTest {
    private final MentorshipRequestRepository requests = mock(MentorshipRequestRepository.class);
    private final MentorshipRequestService service = new MentorshipRequestService(requests, mock(StudentRepository.class), mock(AlumniRepository.class));
    @Test void onlyAlumniCanAcceptRequestedRequest() { assertTrue(service.isAllowed(RequestStatus.REQUESTED, RequestStatus.ACCEPTED, UserRole.ALUMNI)); assertFalse(service.isAllowed(RequestStatus.REQUESTED, RequestStatus.ACCEPTED, UserRole.STUDENT)); }
    @Test void onlyAdminCanCompleteAcceptedRequest() { assertTrue(service.isAllowed(RequestStatus.ACCEPTED, RequestStatus.COMPLETED, UserRole.ADMIN)); assertFalse(service.isAllowed(RequestStatus.ACCEPTED, RequestStatus.COMPLETED, UserRole.ALUMNI)); }
    @Test void rejectedRequestCannotBeReopened() { assertFalse(service.isAllowed(RequestStatus.REJECTED, RequestStatus.ACCEPTED, UserRole.ALUMNI)); }
}
