package com.adrian.mentorship.request;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MentorshipRequestRepository extends JpaRepository<MentorshipRequest, Long> { long countByStatus(RequestStatus status); }
