<?php
namespace App\Controller;

use App\Entity\Patient;
use App\Entity\Reclamation;
use App\Form\ReclamationType;
use App\Repository\PatientRepository;
use App\Repository\ReclamationRepository;
use App\Repository\StadeRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Serializer\Encoder\JsonEncoder;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;

class MobileController extends AbstractController
{
    /**
     * @Route("/mobile", name="mobile")
     */
    public function index(): Response
    {
        return $this->render('mobile/index.html.twig', [
            'controller_name' => 'MobileController',
        ]);
    }

    /**
     * @Route("/listepatient", name="listepatient")

     */
    public function getCours():Response{
       $patient= $this->getDoctrine()->getManager()->getRepository(Patient::class)->findAll();
       $serializer = new Serializer([new ObjectNormalizer()]);
       $formatted = $serializer->normalize($patient);
       return new JsonResponse($formatted);

    }
    /**
     * @Route("/addp", name="add_reclamation")
     */
    public function addReclamation(Request $request){
        $patient= new Patient();
        $clinique_id= $request->query->get("clinique_id");

        $email= $request->query->get("email");
        $phone= $request->query->get("phone");
        $name= $request->query->get("name");
        $adresse= $request->query->get("adresse");

        $patient->setClinique_id($clinique_id);

        $patient->setEmail($email);
        $patient->setPhone($phone);
        $patient->setName($name);
        $patient->setAdresse($adresse);
        $em=$this->getDoctrine()->getManager();
        $em->persist($patient);
        $em->flush();
        $serialize = new Serializer([new ObjectNormalizer()]);
        $formatted = $serialize->normalize("Reclamation Ajoutée");
        return new JsonResponse($formatted);

    }
    /**
     * @Route("/deletepatient", name="deletereclamation", methods={"GET","POST"})
     *
     */
    public function deletepatient(Request $request){
        $id=$request->get('id');
        $entityManager = $this->getDoctrine()->getManager();
        $patient=$entityManager->getRepository(Patient::class)->find($id);
        if($patient!=null){
            $entityManager->remove($patient);
            $entityManager->flush();
            $serialize = new Serializer([new ObjectNormalizer()]);
            $formatted = $serialize->normalize("patient deleted");
            return new JsonResponse($formatted);
        }

    }
    /**
     * @Route("/updatepatient", name="updatepatient", methods={"GET","POST"})
     *
     */
    public function updateReclamation(Request $request){
        $em=$this->getDoctrine()->getManager();
        $patient=$this->getDoctrine()->getManager()->getRepository(Patient::class)->find($request->get("id"));
        $patient->setClinique_id($request->get("clinique_id"));
        $patient->setName($request->get("name"));
        $patient->setEmail($request->get("email"));
        $patient->setPhone($request->get("phone"));
        $patient->setAdresse($request->get("adresse"));

        $em->persist($patient);
        $em->flush();
        $serialize = new Serializer([new ObjectNormalizer()]);
        $formatted = $serialize->normalize("Stade updated");
        return new JsonResponse($formatted);
    }


    /**
     * @Route("/detailpatients", name="detailpatients" , methods={"GET","POST"})
     *
     */



    public function Stadedetail(Request $request,PatientRepository $patientRepository,SerializerInterface $serializerinterface)
    { $id=$request->get('id');
        $repo = $patientRepository->find($id);

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($repo);
        return new JsonResponse($formatted);

    }
}